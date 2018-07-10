package com.appscharles.libs.fxer.parsers;

import com.google.devtools.common.options.OptionsBase;
import com.google.devtools.common.options.OptionsParser;
import com.google.devtools.common.options.OptionsParsingException;

/**
 * The type Args parser.
 */
public class ArgsParser {

    /**
     * Parse t.
     *
     * @param <T>   the type parameter
     * @param args  the args
     * @param clazz the clazz
     * @return the t
     * @throws OptionsParsingException the options parsing exception
     */
    public static <T extends OptionsBase> T parse(String[] args, Class<T> clazz) throws OptionsParsingException {
        OptionsParser parser = OptionsParser.newOptionsParser(clazz);
        parser.parse(args);
        return parser.getOptions(clazz);
    }

}
