package com.airstay.common.rest.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sarwo.wibowo
 *
 * @param <T>
 */
@Setter
@Getter
public class ItemsPayload<T> implements Payload {
	private List<T> items = new ArrayList<>();
}
