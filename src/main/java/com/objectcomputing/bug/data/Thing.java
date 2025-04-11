package com.objectcomputing.bug.data;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.AutoPopulated;
import io.micronaut.data.annotation.TypeDef;
import io.micronaut.data.model.DataType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;
import java.util.UUID;

@Entity
@Introspected
@Table(name = "things")
public class Thing {

    @Id
    @Column(name = "id")
    @AutoPopulated
    @TypeDef(type = DataType.STRING)
    private UUID id;

    @NotNull
    @Column(name = "something")
    @TypeDef(type = DataType.STRING)
    private String something;

    public Thing(UUID id, String something) {
        this.id = id;
        this.something = something;
    }

    public Thing(@Nullable String something) {
        this(null, something);
    }

    public Thing() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Thing{");
        sb.append("id=").append(id);
        sb.append(", something='").append(something).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Thing that = (Thing) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(something, that.something);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, something);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSomething() {
        return something;
    }

    public void setSomething(String something) {
        this.something = something;
    }
}

