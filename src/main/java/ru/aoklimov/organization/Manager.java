package ru.aoklimov.organization;

import ru.aoklimov.util.ArrayUtils;

import java.util.Arrays;

public class Manager extends User {

    private Sales[] sales;

    public Manager(Long id, String fio, String phone, String email, Sales[] sales) {
        super(id, fio, phone, email);
        this.sales = sales;
    }

    public Manager() {
        super();
    }

    public Sales[] getSales() {
        return sales;
    }

    public void setSales(Sales[] sales) {
        this.sales = sales;
    }

    public void setSales(String... sales) {
        this.sales = new Sales[sales.length];
        for (int index = 0; index < sales.length; index++) {
            Sales buffer = new Sales();
            buffer.fromCSV(sales[index]);
            this.sales[index] = buffer;
        }
    }

    @Override
    public String toCSV() {
        return ArrayUtils.concatWithSeparatorToCSV("%", this.getId(), this.getPhone(), this.getFio(), this.getEmail(), sales) + "\n";
    }

    @Override
    public void fromCSV(String CSV) {
        String[] strings = CSV.split("%");
        this.setId(Long.valueOf(strings[0]));
        this.setPhone(strings[1]);
        this.setFio(strings[2]);
        this.setEmail(strings[3]);
        String[] salesCSVs = Arrays.copyOfRange(strings, 4, strings.length);
        this.setSales(salesCSVs);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Manager manager = (Manager) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(sales, manager.sales);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(sales);
        return result;
    }
}
