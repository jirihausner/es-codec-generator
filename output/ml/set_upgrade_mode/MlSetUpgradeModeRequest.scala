package com.converted.elasticsearch.ml.set_upgrade_mode

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	query_parameters: QueryParameters
) extends RequestBase

object Request {
	@JsonCodec case class QueryParameters(
		enabled: Boolean, 
		timeout: Time
	)
}

