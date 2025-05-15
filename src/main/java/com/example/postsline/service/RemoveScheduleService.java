package com.example.postsline.service;

import com.example.postsline.cloudclients.UhabMessengerClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import static com.example.postsline.util.UtilScheduleParams.DAYS_FOR_REMOVE;
import static com.example.postsline.util.UtilScheduleParams.DAYS_FOR_REMOVE_MARK;

@Slf4j
@Service
@RequiredArgsConstructor
public class RemoveScheduleService {

    private final UhabMessengerClient uhabMessengerClient;

    @Scheduled(cron = "0 0/15 * * * *")
    public void removeOrMarkForItSchedule(){

        log.info("scheduling working");
        uhabMessengerClient.schedulePostRemove(DAYS_FOR_REMOVE_MARK, DAYS_FOR_REMOVE);

    }

}
