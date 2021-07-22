package com.converted.elasticsearch.indices._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Id }

@JsonCodec case class IndexRouting(
	allocation: IndexRoutingAllocation, 
	rebalance: IndexRoutingRebalance
)


@JsonCodec case class IndexRoutingAllocation(
	enable: IndexRoutingAllocationOptions, 
	include: IndexRoutingAllocationInclude, 
	initial_recovery: IndexRoutingAllocationInitialRecovery, 
	disk: IndexRoutingAllocationDisk
)


@JsonCodec case class IndexRoutingRebalance(
	enable: IndexRoutingRebalanceOptions
)


object IndexRoutingAllocationOptions extends Enumeration {
	type IndexRoutingAllocationOptions = Value

val all = Value(0, "all")
val primaries = Value(1, "primaries")
val new_primaries = Value(2, "new_primaries")
val none = Value(3, "none")
}

implicit val indexRoutingAllocationOptionsDecoder: Decoder[IndexRoutingAllocationOptions.Value] = Decoder.decodeEnumeration(IndexRoutingAllocationOptions)
implicit val indexRoutingAllocationOptionsEncoder: Encoder[IndexRoutingAllocationOptions.Value] = Decoder.encodeEnumeration(IndexRoutingAllocationOptions)


object IndexRoutingRebalanceOptions extends Enumeration {
	type IndexRoutingRebalanceOptions = Value

val all = Value(0, "all")
val primaries = Value(1, "primaries")
val replicas = Value(2, "replicas")
val none = Value(3, "none")
}

implicit val indexRoutingRebalanceOptionsDecoder: Decoder[IndexRoutingRebalanceOptions.Value] = Decoder.decodeEnumeration(IndexRoutingRebalanceOptions)
implicit val indexRoutingRebalanceOptionsEncoder: Encoder[IndexRoutingRebalanceOptions.Value] = Decoder.encodeEnumeration(IndexRoutingRebalanceOptions)


@JsonCodec case class IndexRoutingAllocationInclude(
	_tier_preference: String, 
	_id: Id
)


@JsonCodec case class IndexRoutingAllocationInitialRecovery(
	_id: Id
)


@JsonCodec case class IndexRoutingAllocationDisk(
	threshold_enabled: Boolean | String
)
