package com.gmail.macieq44.motivateme.backend.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * Created by Macieq44 on 26.11.2017.
 */
@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private int version;

    public boolean isNew() {
        return id == null;
    }

    public Long getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    @Override
    public int hashCode() {
        if (id == null) {
            return super.hashCode();
        }

        return 57 + id.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (id == null) {
            return super.equals(other);
        }

        if (this == other) {
            return true;
        }

        if (!(other instanceof AbstractEntity)) {
            return false;
        }

        return id.equals(((AbstractEntity) other).id);
    }

}
