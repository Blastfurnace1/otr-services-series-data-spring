package com.blastfurnace.otr.rest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blastfurnace.otr.data.series.SeriesService;
import com.blastfurnace.otr.data.series.model.Series;
import com.blastfurnace.otr.data.series.service.model.SeriesDataWrapper;
import com.blastfurnace.otr.rest.request.QueryData;
import com.blastfurnace.otr.rest.service.SeriesDataService;
import com.blastfurnace.otr.service.response.GenericResponse;
import com.blastfurnace.otr.util.reflection.ObjectData;
import com.blastfurnace.otr.util.reflection.Utils;


@Component("SeriesDatumService")
public class SeriesDataServiceImpl implements SeriesDataService {

	@Autowired
	private SeriesService service;


	/* (non-Javadoc)
	 * @see com.blastfurnace.otr.rest.adapter.SeriesDataAdapter#get(java.lang.Long)
	 */
	@Override
	public GenericResponse<SeriesDataWrapper> get(Long id) {
		GenericResponse<SeriesDataWrapper> response = new GenericResponse<SeriesDataWrapper>(null);
		try {
			SeriesDataWrapper series = service.get(id);
			response.setPayload(series);

			if (series == null) {
				response.setStatus(10l);
				response.setMessage("No Results found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(-10l);
			response.setMessage("An Error Occurred - unable to get a result");
			response.setErrorOccured(true);
			response.addError(e.getMessage());
		}

		return response;
	}


	/* (non-Javadoc)
	 * @see com.blastfurnace.otr.rest.adapter.SeriesDataAdapter#query(com.blastfurnace.otr.rest.request.QueryData)
	 */
	@Override
	public GenericResponse<List<Map<String,Object>>> query(QueryData qry) {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		GenericResponse<List<Map<String,Object>>> response = new GenericResponse<List<Map<String,Object>>>(list);
		try {
			String[] columns = Utils.getFields(qry);

			Iterable<Series> props = service.query(qry);

			if (props == null) {
				response.setStatus(10l);
				response.setMessage("No Results found");
			} else {
				for (Series afp : props) {
					ObjectData<Series> obj = new ObjectData<Series>(afp);
					Map<String,Object> map = null;
					try {
						map = obj.addValues(columns, Series.fieldDefinitions);
					} catch (Exception  e) {
						response.setErrorOccured(true);
						response.addError(e.getMessage());
					}
					list.add(map);
				}

				if (list.isEmpty() && response.getErrorOccured() == false) {
					response.setStatus(10l);
					response.setMessage("No Results found");
				}

				if (response.getErrorOccured()) {
					response.setStatus(-20l);
					response.setMessage("unable to get complete data");
				}
				response.setPayload(list);
			}
		} catch (Exception e) {
			response.setStatus(-10l);
			response.setMessage("An Error Occurred - unable to get results");
			response.setErrorOccured(true);
			response.addError(e.getMessage());
		}
		return response;
	}

	/* (non-Javadoc)
	 * @see com.blastfurnace.otr.rest.adapter.SeriesDataAdapter#getResultsCount(com.blastfurnace.otr.rest.request.QueryData)
	 */
	@Override
	public GenericResponse<Long> getResultsCount(QueryData qry) {
		GenericResponse<Long> response = new GenericResponse<Long>(null);
		try {
			Long count = service.getResultsCount(qry);
			response.setPayload(count);
			if (count == null) {
				response.setStatus(-30l);
				response.setMessage("Unable to save Record");
			}
		} catch (Exception e) {
			response.setStatus(-10l);
			response.setMessage("An Error Occurred - unable to get a result count");
			response.setErrorOccured(true);
			response.addError(e.getMessage());
		}

		return response;
	}



	/* (non-Javadoc)
	 * @see com.blastfurnace.otr.rest.adapter.SeriesDataAdapter#delete(java.lang.Long)
	 */
	@Override
	public GenericResponse<String> delete(Long  id) {

		GenericResponse<String> response = new GenericResponse<String>("");
		try {
			service.delete(id);
		} catch (Exception e) {
			response.setStatus(-10l);
			response.setMessage("An Error Occurred - unable to delete record");
			response.setErrorOccured(true);
			response.addError(e.getMessage());
		}

		return response;
	}

	/* (non-Javadoc)
	 * @see com.blastfurnace.otr.rest.adapter.SeriesDataAdapter#save(com.blastfurnace.otr.model.Series)
	 */
	@Override
	public GenericResponse<SeriesDataWrapper> save(SeriesDataWrapper series) {
		GenericResponse<SeriesDataWrapper> response = new GenericResponse<SeriesDataWrapper>(null);
		if (series == null) {
			response.setStatus(-50l);
			response.setMessage("Unable to save Record - nothing to save");
			return response;
		} 
		try {
			SeriesDataWrapper newSeries = service.save(series);
			response.setPayload(newSeries);
			if (newSeries == null) {
				response.setStatus(-50l);
				response.setMessage("Unable to save Record");
			}
		} catch (Exception e) {
			response.setStatus(-10l);
			response.setMessage("An Error Occurred - unable to get a result");
			response.setErrorOccured(true);
			response.addError(e.getMessage());
		}

		return response;
	}
}
