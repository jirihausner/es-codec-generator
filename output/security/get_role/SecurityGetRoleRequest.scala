package com.converted.elasticsearch.security.get_role

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Name }

@JsonCodec case class Request(
	path_parts: PathParts
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		name: Name
	)
}

