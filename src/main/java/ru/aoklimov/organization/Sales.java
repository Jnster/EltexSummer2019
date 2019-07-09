package ru.aoklimov.organization;

import ru.aoklimov.util.ArrayUtils;

import java.util.Arrays;

public class Sales implements CSV {
    private Long id;
    private String[] items;
    private Double cost;

    public Sales(Long id, String[] items, Double cost) {
        this.id = id;
        this.items = items;
        this.cost = cost;
    }

    public Sales() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toCSV() {
        return ArrayUtils.concatWithSeparatorToCSV("#", id, cost, items);
    }

    @Override
    public void fromCSV(String CSV) {
        String[] values = CSV.split("#");
        this.id = Long. valueOf(values[0]);
        this.cost = Double.valueOf(values[1]);
        this.items = Arrays.copyOfRange(values, 2, values.length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sales sales = (Sales) o;

        if (id != null ? !id.equals(sales.id) : sales.id != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(items, sales.items)) return false;
        return cost != null ? cost.equals(sales.cost) : sales.cost == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(items);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        return result;
    }
}
