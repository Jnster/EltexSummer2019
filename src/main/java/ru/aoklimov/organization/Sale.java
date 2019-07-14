package ru.aoklimov.organization;

import org.jetbrains.annotations.NotNull;
import ru.aoklimov.util.ArrayUtils;

import java.util.Arrays;
import java.util.Objects;

public class Sale implements CSV, Comparable<Sale> {
    private Long id;
    private String[] items;
    private Double cost;

    public Sale(Long id, String[] items, Double cost) {
        this.id = id;
        this.items = items;
        this.cost = cost;
    }

    public Sale() {

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

        Sale sale = (Sale) o;

        if (!Objects.equals(id, sale.id)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(items, sale.items)) return false;
        return Objects.equals(cost, sale.cost);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(items);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(@NotNull Sale sale) {
        return this.id.compareTo(sale.getId()) + this.cost.compareTo(sale.getCost())
                + Arrays.compare(this.items, sale.getItems());
    }
}
