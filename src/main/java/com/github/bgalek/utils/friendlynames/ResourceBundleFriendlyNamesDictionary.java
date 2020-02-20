package com.github.bgalek.utils.friendlynames;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

class ResourceBundleFriendlyNamesDictionary extends DefaultFriendlyNamesDictionary {

    private static final String DICTIONARY_BUNDLE = "DictionaryBundle";
    private static final String ADJECTIVES_KEY = "adjectives";
    private static final String NAMES_KEY = "names";

    ResourceBundleFriendlyNamesDictionary() {
        this(Locale.getDefault());
    }

    ResourceBundleFriendlyNamesDictionary(Locale locale) {
        super(getSetOfProperty(NAMES_KEY, locale), getSetOfProperty(ADJECTIVES_KEY, locale));
    }

    private static Set<String> getSetOfProperty(String key, Locale locale) {
        return Set.of(ResourceBundle.getBundle(DICTIONARY_BUNDLE, locale).getString(key).split(","));
    }
}
