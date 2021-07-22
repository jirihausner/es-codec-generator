package com.converted.elasticsearch.ilm.remove_policy

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ IndexName }

@JsonCodec case class Request(
	path_parts: PathParts
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		index: IndexName
	)
}

