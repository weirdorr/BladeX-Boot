/*
 *      Copyright (c) 2018-2028, Chill Zhuang All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the dreamlu.net developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: Chill 庄骞 (smallchill@163.com)
 */
package org.springblade.modules.auth.granter;

import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TokenGranterBuilder
 *
 * @author Chill
 */
@AllArgsConstructor
public class TokenGranterBuilder {

	/**
	 * TokenGranter缓存池子
	 */
	private static Map<String, ITokenGranter> granterPool = new ConcurrentHashMap<>();

	static {
		granterPool.put(PasswordTokenGranter.GRANT_TYPE, new PasswordTokenGranter());
		granterPool.put(RefreshTokenGranter.GRANT_TYPE, new RefreshTokenGranter());
	}

	/**
	 * 获取TokenGranter
	 *
	 * @param grantType 授权类型
	 * @return ITokenGranter
	 */
	public static ITokenGranter getGranter(String grantType) {
		return granterPool.get(grantType);
	}

}