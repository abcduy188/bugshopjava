package com.bugshop.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

	public static List<String> getAuthorities(){
		List<String> results = new ArrayList<>();
		
		@SuppressWarnings("unchecked")
		List<GrantedAuthority> authorities = (List<GrantedAuthority>)(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		
		//foreach get author cua user
        for (GrantedAuthority authority : authorities) {
            results.add(authority.getAuthority());
        }
		return results;
	}
}
