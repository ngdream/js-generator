package com.osscameroon.jsgenerator.core;

import com.osscameroon.jsgenerator.core.internal.ConverterDefault;
import lombok.NonNull;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Converter
 *
 * @author Salathiel @t salathiel@genese.name
 * @since Sep 02, 2022 @t 23:19:40
 */
@FunctionalInterface
public interface Converter {
    void convert(@NonNull final InputStream inputStream, @NonNull final OutputStream outputStream);

    default void convert(@NonNull final Flow flow) {
        convert(flow.getInputStream(), flow.getOutputStream());
    }

    static Converter of(@NonNull final NameGenerationStrategy nameGenerationStrategy) {
        return new ConverterDefault(nameGenerationStrategy);
    }
}