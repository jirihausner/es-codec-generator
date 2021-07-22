package com.converted.elasticsearch.cat.tasks

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._cat._types.CatBase.{ CatRequestBase }
import com.converted.elasticsearch._types.Numeric.{ long }

@JsonCodec case class Request(
	query_parameters: QueryParameters, 
	body: Body
) extends CatRequestBase

object Request {
	@JsonCodec case class QueryParameters(
		actions: Array(String), 
		detailed: Boolean, 
		node_id: Array(String), 
		parent_task: Long
	)
	@JsonCodec case class Body(
	)
}

