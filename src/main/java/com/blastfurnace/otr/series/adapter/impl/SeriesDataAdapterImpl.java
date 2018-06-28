package com.blastfurnace.otr.series.adapter.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blastfurnace.otr.data.series.service.model.SeriesDataWrapper;
import com.blastfurnace.otr.rest.request.QueryData;
import com.blastfurnace.otr.series.adapter.SeriesDataAdapter;
import com.blastfurnace.otr.series.service.SeriesDataService;
import com.blastfurnace.otr.service.response.GenericResponse;


@Component("SeriesDataAdapter")
public class SeriesDataAdapterImpl implements SeriesDataAdapter {

	@Autowired
	private SeriesDataService service;


	/* (non-Javadoc)
	 * @see com.blastfurnace.otr.rest.adapter.SeriesDataAdapter#get(java.lang.Long)
	 */
	@Override
	public GenericResponse<SeriesDataWrapper> get(Long id) {
		return service.get(id);
	}

	/* (non-Javadoc)
	 * @see com.blastfurnace.otr.rest.adapter.SeriesDataAdapter#query(com.blastfurnace.otr.rest.request.QueryData)
	 */
	@Override
	public GenericResponse<List<Map<String,Object>>> query(QueryData qry) {
		return service.query(qry);
	}

	/* (non-Javadoc)
	 * @see com.blastfurnace.otr.rest.adapter.SeriesDataAdapter#getResultsCount(com.blastfurnace.otr.rest.request.QueryData)
	 */
	@Override
	public GenericResponse<Long> getResultsCount(QueryData qry) {
		return service.getResultsCount(qry);
	}

	/* (non-Javadoc)
	 * @see com.blastfurnace.otr.rest.adapter.SeriesDataAdapter#delete(java.lang.Long)
	 */
	@Override
	public GenericResponse<String> delete(Long  id) {
		return service.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.blastfurnace.otr.rest.adapter.SeriesDataAdapter#save(com.blastfurnace.otr.model.Series)
	 */
	@Override
	public GenericResponse<SeriesDataWrapper> save(SeriesDataWrapper series) {
		return service.save(series);
	}
}
