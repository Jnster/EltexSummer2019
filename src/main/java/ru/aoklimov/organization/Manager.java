package ru.aoklimov.organization;

import org.jetbrains.annotations.NotNull;
import ru.aoklimov.util.ArrayUtils;

import java.util.Arrays;

public class Manager extends User implements Comparable<Manager> {

    private Sale[] sales;

    public Manager(Long id, String fio, String phone, String email, Sale[] sales) {
        super(id, fio, phone, email);
        this.sales = sales;
    }

    public Manager() {
        super();
    }

    public Sale[] getSales() {
        return sales;
    }

    public void setSales(Sale[] sales) {
        this.sales = sales;
    }

    public void setSales(String... sales) {
        this.sales = new Sale[sales.length];
        for (int index = 0; index < sales.length; index++) {
            Sale buffer = new Sale();
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

    @Override
    public int compareTo(@NotNull Manager manager) {
        return this.getPhone().compareTo(manager.getPhone()) + this.getFio().compareTo(manager.getFio())
                + this.getEmail().compareTo(manager.getEmail()) + this.getId().compareTo(manager.getId())
                + Arrays.compare(this.sales, manager.getSales());
    }
}
