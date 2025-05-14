package com.example.postsline.service;

import com.example.postsline.cloudclients.UhabMessengerClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RemoveScheduleService {

    private final UhabMessengerClient uhabMessengerClient;

    private final static Integer DAYS_FOR_REMOVE_MARK = 2;
    private final static Integer DAYS_FOR_REMOVE = 15;

    @Scheduled(cron = "10 31 16 * * *")
    public void removeOrMarkForItSchedule(){

        log.info("scheduling working");
        uhabMessengerClient.schedulePostRemove(DAYS_FOR_REMOVE_MARK, DAYS_FOR_REMOVE);

    }

}
