package com.example.postsline.service;

import com.example.postsline.cloudclients.UhabMessengerClient;
import com.example.postsline.dto.PostWithLikesInfoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.example.postsline.util.PostLineComparator.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class LineService {

    private final UhabMessengerClient messengerClient;

    public List<PostWithLikesInfoDto> getAllPostInfoList() {

        log.info("- -  @GetMapping(value = \"/post-line/post-info/all\") ");
        return messengerClient.getAllPosts();

    }

    public List<PostWithLikesInfoDto> getAllByParams(Integer pageSize,
                                                     Boolean isSortedByLikesAndComments,
                                                     String searchedBy) {

        List<PostWithLikesInfoDto> withoutSortedResultList = getAllPostInfoList();

        sortedByLikesAndComments(withoutSortedResultList, isSortedByLikesAndComments);

        searchingByWords(withoutSortedResultList, searchedBy);

        cutByPageSize(withoutSortedResultList, pageSize);

        return withoutSortedResultList;

    }

    private void searchingByWords(List<PostWithLikesInfoDto> withoutSortedResultList, String searchedBy) {

        if (Objects.nonNull(searchedBy)) {

            withoutSortedResultList.sort(compareBySearchingWords(searchedBy));

        }

    }

    private void sortedByLikesAndComments(List<PostWithLikesInfoDto> withoutSortedResultList, Boolean isSortedByLikesAndComments) {

        if (Objects.nonNull(isSortedByLikesAndComments) && isSortedByLikesAndComments) {

            withoutSortedResultList.sort(compareByLikesAndCommentsCount);

        }

    }

    private void cutByPageSize(List<PostWithLikesInfoDto> list, int pageSize) {

        if (list.size() > pageSize) {
            list.subList(pageSize, list.size()).clear();
        }

    }

}
