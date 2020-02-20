package com.github.bgalek.utils.friendlynames;

import java.util.Iterator;
import java.util.Locale;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public final class FriendlyNames {

    private final Iterator<String> iterator;

    private FriendlyNames(FriendlyNamesDictionary friendlyNamesDictionary) {
        this.iterator = friendlyNamesDictionary.iterator();
    }

    public static FriendlyNames defaultDictionary() {
        return new FriendlyNames(new ResourceBundleFriendlyNamesDictionary());
    }

    public static FriendlyNames defaultDictionary(Locale locale) {
        return new FriendlyNames(new ResourceBundleFriendlyNamesDictionary(locale));
    }

    public static FriendlyNames customDictionary(FriendlyNamesDictionary friendlyNamesDictionary) {
        return new FriendlyNames(friendlyNamesDictionary);
    }

    public Stream<String> stream() {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, 0), false);
    }

    public String random() {
        return iterator.next();
    }
}
