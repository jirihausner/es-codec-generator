package com.converted.elasticsearch.indices.exists

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ ExpandWildcards, Indices }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		index: Indices
	)
	@JsonCodec case class QueryParameters(
		allow_no_indices: Boolean, 
		expand_wildcards: ExpandWildcards, 
		flat_settings: Boolean, 
		ignore_unavailable: Boolean, 
		include_defaults: Boolean, 
		local: Boolean
	)
	@JsonCodec case class Body(
	)
}

