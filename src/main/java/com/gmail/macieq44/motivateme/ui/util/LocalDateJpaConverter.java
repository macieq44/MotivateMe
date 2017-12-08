package com.gmail.macieq44.motivateme.ui.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Created by Macieq44 on 08.12.2017.
 */
@Converter(autoApply = true)
public class LocalDateJpaConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate localDate) {
        if (localDate == null) {
            return null;
        }

        return Date.valueOf(localDate);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date date) {
        if (date == null) {
            return null;
        }

         return date.toLocalDate();
    }
}
