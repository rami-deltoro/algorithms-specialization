package org.example.exersizes;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/subdomain-visit-count/
 */
@Slf4j
public class SubdomainVisitCount {


    public List<String> subdomainVisits(String[] cpdomains) {
        final List<String> returnList = new ArrayList<>();
        final Map<String,Integer> hostCount = new HashMap<>();

        for (String cpdomain : cpdomains) {
            List<String> hosts = getHosts(cpdomain);
            int count = getCount(cpdomain);

            for (String host : hosts) {
                int countFromMap = hostCount.getOrDefault(host, 0);
                int totalCount = countFromMap + count;
                hostCount.put(host, totalCount);
            }
        }

        for (Map.Entry<String, Integer> entry : hostCount.entrySet()) {
            returnList.add(entry.getValue()+" "+entry.getKey());
        }

        return returnList;
    }

    private int getCount(String domain) {
        StringBuilder stringBuilder = new StringBuilder();

        for(int i=0;i<domain.length();i++) {
            if(domain.charAt(i) == ' ') {
                break;
            }
            stringBuilder.append(domain.charAt(i));
        }

        return Integer.valueOf(stringBuilder.toString());
    }

    private List<String> getHosts(final String domain) {
        final StringBuilder domainStringBuilder = new StringBuilder();
        final StringBuilder hostStringBuilder = new StringBuilder();
        final List<String> hosts = new ArrayList<>();

        for(int i=domain.length()-1;i>=0;i--) {
            if (domain.charAt(i) == ' ') {
                hostStringBuilder.insert(0,domainStringBuilder.reverse().toString());
                hosts.add(hostStringBuilder.toString());
                break;
            }

            if (domain.charAt(i) == '.') {
                hostStringBuilder.insert(0,domainStringBuilder.reverse().toString());
                domainStringBuilder.setLength(0);
                hosts.add(hostStringBuilder.toString());
            }

            domainStringBuilder.append(domain.charAt(i));
        }

        return hosts;
    }
}
