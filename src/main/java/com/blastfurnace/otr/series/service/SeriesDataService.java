package com.blastfurnace.otr.series.service;

import java.util.List;
import java.util.Map;

import com.blastfurnace.otr.data.series.service.model.SeriesDataWrapper;
import com.blastfurnace.otr.service.request.QueryData;
import com.blastfurnace.otr.service.response.GenericServiceResponse;

public interface SeriesDataService {

	GenericServiceResponse<SeriesDataWrapper> get(Long id);

	GenericServiceResponse<List<Map<String, Object>>> query(QueryData qry);

	GenericServiceResponse<Long> getResultsCount(QueryData qry);

	GenericServiceResponse<String> delete(Long id);

	GenericServiceResponse<SeriesDataWrapper> save(SeriesDataWrapper series);

}