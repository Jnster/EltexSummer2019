package ru.aoklimov.organization;

import org.jetbrains.annotations.NotNull;
import ru.aoklimov.util.ArrayUtils;

import java.util.Arrays;

public class Developer extends User implements Comparable<Developer> {

    private String[] languages;

    public Developer(Long id, String fio, String phone, String email, String[] languages) {
        super(id, fio, phone, email);
        this.languages = languages;
    }

    public Developer() {
        super();
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    @Override
    public String toCSV() {
        return ArrayUtils.concatWithSeparatorToCSV("&", this.getId(), this.getPhone(), this.getFio(), this.getEmail(), languages) + "\n";
    }

    @Override
    public void fromCSV(String CSV) {
        String[] strings = CSV.split("&");
        this.setId(Long.valueOf(strings[0]));
        this.setPhone(strings[1]);
        this.setFio(strings[2]);
        this.setEmail(strings[3]);
        this.setLanguages(Arrays.copyOfRange(strings, 4, strings.length));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Developer developer = (Developer) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(languages, developer.languages);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(languages);
        return result;
    }

    @Override
    public int compareTo(@NotNull Developer developer) {
        return this.getPhone().compareTo(developer.getPhone()) + this.getFio().compareTo(developer.getFio())
                + this.getEmail().compareTo(developer.getEmail()) + this.getId().compareTo(developer.getId())
                + Arrays.compare(this.languages, developer.getLanguages());
    }
}
