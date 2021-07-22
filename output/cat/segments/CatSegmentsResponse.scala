package com.converted.elasticsearch.cat.segments

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.cat.segments.{ SegmentsRecord }

@JsonCodec case class Response(
	body: Array(SegmentsRecord)
)

