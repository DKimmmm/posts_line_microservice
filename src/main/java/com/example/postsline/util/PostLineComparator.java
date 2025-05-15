package com.example.postsline.util;

import com.example.postsline.dto.PostWithLikesInfoDto;

import java.util.Comparator;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostLineComparator {

    public final static Comparator<PostWithLikesInfoDto> compareByLikesAndCommentsCount = (p1, p2) -> {
        int score1 = p1.getCommentCount() * 2 + p1.getLikeCount();
        int score2 = p2.getCommentCount() * 2 + p2.getLikeCount();
        return Integer.compare(score2, score1);
    };

    public static Comparator<PostWithLikesInfoDto> compareBySearchingWords(String searchQuery) {
        return new PostSearchComparator(searchQuery);
    }

    public final static class PostSearchComparator implements Comparator<PostWithLikesInfoDto> {

        private final String searchQuery;

        public PostSearchComparator(String searchQuery) {
            this.searchQuery = Objects.nonNull(searchQuery) ? searchQuery.toLowerCase() : "";
        }

        @Override
        public int compare(PostWithLikesInfoDto p1, PostWithLikesInfoDto p2) {

            double score1 = calculateScore(p1);
            double score2 = calculateScore(p2);

            return Double.compare(score2, score1);

        }

        private double calculateScore(PostWithLikesInfoDto post) {

            int titleMatches = countMatches(post.getTitle(), searchQuery);
            int descriptionMatches = countMatches(post.getDescription(), searchQuery);

            return titleMatches * 5.0 + descriptionMatches;

        }

        private int countMatches(String text, String query) {

            if (text == null || query == null || query.isEmpty()) {
                return 0;
            }

            text = text.toLowerCase();

            return findCoincidenceCount(text, query);


        }

        /**
         * Ищем совпадения слова или фразы
         * @param text - searching by that text
         * @param query - searching by that query
         * @return - score coincidence
         */

        private int findCoincidenceCount(String text, String query) {

            Pattern pattern = Pattern.compile("\\b" + Pattern.quote(query) + "\\b");
            Matcher matcher = pattern.matcher(text);

            int count = 0;

            while (matcher.find()) {
                count++;
            }
            return count;

        }
    }


}
