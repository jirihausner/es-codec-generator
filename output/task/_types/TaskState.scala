package com.converted.elasticsearch.task._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ HttpHeaders, TaskId }
import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch.task._types.{ Status }

@JsonCodec case class State(
	action: String, 
	cancellable: Boolean, 
	description: String, 
	headers: HttpHeaders, 
	id: Long, 
	node: String, 
	parent_task_id: TaskId, 
	running_time_in_nanos: Long, 
	start_time_in_millis: Long, 
	status: Status, 
	`type`: String
)

