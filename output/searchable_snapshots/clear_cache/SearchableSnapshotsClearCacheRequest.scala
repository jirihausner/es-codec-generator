package com.converted.elasticsearch.searchable_snapshots.clear_cache

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ ExpandWildcards, Indices }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		index: Indices
	)
	@JsonCodec case class QueryParameters(
		expand_wildcards: ExpandWildcards, 
		allow_no_indices: Boolean, 
		ignore_unavailable: Boolean, 
		pretty: Boolean, 
		human: Boolean
	)
}

