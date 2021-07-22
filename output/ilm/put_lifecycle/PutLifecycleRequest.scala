package com.converted.elasticsearch.ilm.put_lifecycle

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._ilm._types.Policy.{ Policy }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Id, Name }

@JsonCodec case class Request(
	path_parts: PathParts, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		policy: Name, 
		policy_id: Id
	)
	@JsonCodec case class Body(
		policy: Policy
	)
}
