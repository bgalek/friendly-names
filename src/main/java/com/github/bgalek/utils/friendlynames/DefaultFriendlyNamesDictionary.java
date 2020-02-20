package com.github.bgalek.utils.friendlynames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class DefaultFriendlyNamesDictionary implements FriendlyNamesDictionary {

    static final String NAME_FORMAT = "%s-%s";

    private final Set<String> names;
    private final Set<String> adjectives;

    public DefaultFriendlyNamesDictionary(Set<String> names, Set<String> adjectives) {
        if (Objects.isNull(names) || names.isEmpty())
            throw new FriendlyNamesDictionaryException("No names provided.");

        if (Objects.isNull(adjectives) || adjectives.isEmpty())
            throw new FriendlyNamesDictionaryException("No adjectives provided.");

        ArrayList<String> namesList = new ArrayList<>(names);
        ArrayList<String> adjectivesList = new ArrayList<>(adjectives);

        Collections.shuffle(namesList);
        Collections.shuffle(adjectivesList);

        this.names = new LinkedHashSet<>(namesList);
        this.adjectives = new LinkedHashSet<>(adjectivesList);
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {

            private Iterator<String> namesIterator = names.iterator();
            private Iterator<String> adjectivesIterator = adjectives.iterator();

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public String next() {
                if (!namesIterator.hasNext()) namesIterator = names.iterator();
                if (!adjectivesIterator.hasNext()) adjectivesIterator = adjectives.iterator();
                return String.format(NAME_FORMAT, adjectivesIterator.next(), namesIterator.next());
            }
        };
    }
}
