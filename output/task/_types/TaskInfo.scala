package com.converted.elasticsearch.task._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._task._types.TaskStatus.{ Status }
import com.converted.elasticsearch._types.common.{ HttpHeaders, Id }
import com.converted.elasticsearch._types.Numeric.{ long }

@JsonCodec case class Info(
	action: String, 
	cancellable: Boolean, 
	children: Array(Info), 
	description: String, 
	headers: HttpHeaders, 
	id: Long, 
	node: String, 
	running_time_in_nanos: Long, 
	start_time_in_millis: Long, 
	status: Status, 
	`type`: String, 
	parent_task_id: Id
)

