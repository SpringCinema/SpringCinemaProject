package com.esc.springcinema.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class UserUniqueIdManager {
    private final int EXPIRE_DAYS = 3; // 만료날짜
    
    private ConcurrentHashMap<String, String> uniqueIdMap; // 저장공간
    
    public UserUniqueIdManager() {
        uniqueIdMap = new ConcurrentHashMap<>();
    }
    
    // 고유값과 생성된 날짜를 포함하여 저장하고 생성된 고유값을 반환
    // 마지막 작성일 : 2022-12-27
    // 작성자 : MoonNight285
    public String setUniqueId(String userId) {
        String uniqueId = UUID.randomUUID().toString();
        LocalDateTime today = LocalDateTime.now();
        uniqueIdMap.put(uniqueId + "_" + today, userId);
        return uniqueId + "_" + today;
    }
    
    // 해당하는 고유값이 없는경우 null 반환
    // 마지막 작성일 : 2022-12-27
    // 작성자 : MoonNight285
    public String getUniqueId(String uniqueId) {
        return uniqueIdMap.get(uniqueId);
    }
    
    // 특정 고유값을 삭제
    // 마지막 작성일 : 2022-12-27
    // 작성자 : MoonNight285
    public void deleteUniqueId(String uniqueId) {
        uniqueIdMap.remove(uniqueId);
    }
    
    // 하루마다 세션에 저장된 날짜를 구해서 만료일이 지났다면 삭제한다.
    // 마지막 작성일 : 2022-12-27
    // 작성자 : MoonNight285
    @Scheduled(fixedRate = 86400000)
    private void expire() {
        LocalDateTime today = LocalDateTime.now();
    
        Iterator<String> iterator = uniqueIdMap.keySet().iterator();
        
        while(iterator.hasNext()) {
            String uniqueId = iterator.next();
            String saveStrDate = uniqueId.split("_")[1];
            LocalDateTime saveLocalDate = LocalDateTime.parse(saveStrDate);
            Period diff = Period.between(saveLocalDate.toLocalDate(), today.toLocalDate());
    
            if (diff.getDays() > EXPIRE_DAYS) {
                iterator.remove();
            }
        }
    }
}
