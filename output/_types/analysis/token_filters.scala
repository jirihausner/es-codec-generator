package com.converted.elasticsearch._types.analysis

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ VersionString }
import com.converted.elasticsearch._types.Numeric.{ integer }
import com.converted.elasticsearch._types.Scripting.{ Script }
import com.converted.elasticsearch._types.analysis.{ SnowballLanguage }
import com.converted.elasticsearch._types.analysis.{ StopWords }

@JsonCodec case class TokenFilterBase(
	`type`: String, 
	version: VersionString
)


@JsonCodec case class CompoundWordTokenFilterBase(
	hyphenation_patterns_path: String, 
	max_subword_size: integer, 
	min_subword_size: integer, 
	min_word_size: integer, 
	only_longest_match: Boolean, 
	word_list: Array(String), 
	word_list_path: String
) extends TokenFilterBase


@JsonCodec case class DictionaryDecompounderTokenFilter extends CompoundWordTokenFilterBase


@JsonCodec case class HyphenationDecompounderTokenFilter extends CompoundWordTokenFilterBase


object DelimitedPayloadEncoding extends Enumeration {
	type DelimitedPayloadEncoding = Value

val int = Value(0, "int")
val float = Value(1, "float")
val identity = Value(2, "identity")
}

implicit val delimitedPayloadEncodingDecoder: Decoder[DelimitedPayloadEncoding.Value] = Decoder.decodeEnumeration(DelimitedPayloadEncoding)
implicit val delimitedPayloadEncodingEncoder: Encoder[DelimitedPayloadEncoding.Value] = Decoder.encodeEnumeration(DelimitedPayloadEncoding)


@JsonCodec case class DelimitedPayloadTokenFilter(
	delimiter: String, 
	encoding: DelimitedPayloadEncoding
) extends TokenFilterBase


object EdgeNGramSide extends Enumeration {
	type EdgeNGramSide = Value

val front = Value(0, "front")
val back = Value(1, "back")
}

implicit val edgeNGramSideDecoder: Decoder[EdgeNGramSide.Value] = Decoder.decodeEnumeration(EdgeNGramSide)
implicit val edgeNGramSideEncoder: Encoder[EdgeNGramSide.Value] = Decoder.encodeEnumeration(EdgeNGramSide)


@JsonCodec case class EdgeNGramTokenFilter(
	max_gram: integer, 
	min_gram: integer, 
	side: EdgeNGramSide
) extends TokenFilterBase


@JsonCodec case class ShingleTokenFilter(
	filler_token: String, 
	max_shingle_size: integer, 
	min_shingle_size: integer, 
	output_unigrams: Boolean, 
	output_unigrams_if_no_shingles: Boolean, 
	token_separator: String
) extends TokenFilterBase


@JsonCodec case class StopTokenFilter(
	ignore_case: Boolean, 
	remove_trailing: Boolean, 
	stopwords: StopWords, 
	stopwords_path: String
) extends TokenFilterBase


object SynonymFormat extends Enumeration {
	type SynonymFormat = Value

val solr = Value(0, "solr")
val wordnet = Value(1, "wordnet")
}

implicit val synonymFormatDecoder: Decoder[SynonymFormat.Value] = Decoder.decodeEnumeration(SynonymFormat)
implicit val synonymFormatEncoder: Encoder[SynonymFormat.Value] = Decoder.encodeEnumeration(SynonymFormat)


@JsonCodec case class SynonymGraphTokenFilter(
	expand: Boolean, 
	format: SynonymFormat, 
	lenient: Boolean, 
	synonyms: Array(String), 
	synonyms_path: String, 
	tokenizer: String, 
	updateable: Boolean
) extends TokenFilterBase


@JsonCodec case class SynonymTokenFilter(
	expand: Boolean, 
	format: SynonymFormat, 
	lenient: Boolean, 
	synonyms: Array(String), 
	synonyms_path: String, 
	tokenizer: String, 
	updateable: Boolean
) extends TokenFilterBase


@JsonCodec case class WordDelimiterTokenFilter(
	catenate_all: Boolean, 
	catenate_numbers: Boolean, 
	catenate_words: Boolean, 
	generate_number_parts: Boolean, 
	generate_word_parts: Boolean, 
	preserve_original: Boolean, 
	protected_words: Array(String), 
	protected_words_path: String, 
	split_on_case_change: Boolean, 
	split_on_numerics: Boolean, 
	stem_english_possessive: Boolean, 
	type_table: Array(String), 
	type_table_path: String
) extends TokenFilterBase


@JsonCodec case class WordDelimiterGraphTokenFilter(
	adjust_offsets: Boolean, 
	catenate_all: Boolean, 
	catenate_numbers: Boolean, 
	catenate_words: Boolean, 
	generate_number_parts: Boolean, 
	generate_word_parts: Boolean, 
	preserve_original: Boolean, 
	protected_words: Array(String), 
	protected_words_path: String, 
	split_on_case_change: Boolean, 
	split_on_numerics: Boolean, 
	stem_english_possessive: Boolean, 
	type_table: Array(String), 
	type_table_path: String
) extends TokenFilterBase


@JsonCodec case class AsciiFoldingTokenFilter(
	preserve_original: Boolean
) extends TokenFilterBase


@JsonCodec case class CommonGramsTokenFilter(
	common_words: Array(String), 
	common_words_path: String, 
	ignore_case: Boolean, 
	query_mode: Boolean
) extends TokenFilterBase


@JsonCodec case class ConditionTokenFilter(
	filter: Array(String), 
	script: Script
) extends TokenFilterBase


@JsonCodec case class ElisionTokenFilter(
	articles: Array(String), 
	articles_case: Boolean
) extends TokenFilterBase


@JsonCodec case class FingerprintTokenFilter(
	max_output_size: integer, 
	separator: String
) extends TokenFilterBase


@JsonCodec case class HunspellTokenFilter(
	dedup: Boolean, 
	dictionary: String, 
	locale: String, 
	longest_only: Boolean
) extends TokenFilterBase


object KeepTypesMode extends Enumeration {
	type KeepTypesMode = Value

val include = Value(0, "include")
val exclude = Value(1, "exclude")
}

implicit val keepTypesModeDecoder: Decoder[KeepTypesMode.Value] = Decoder.decodeEnumeration(KeepTypesMode)
implicit val keepTypesModeEncoder: Encoder[KeepTypesMode.Value] = Decoder.encodeEnumeration(KeepTypesMode)


@JsonCodec case class KeepTypesTokenFilter(
	mode: KeepTypesMode, 
	types: Array(String)
) extends TokenFilterBase


@JsonCodec case class KeepWordsTokenFilter(
	keep_words: Array(String), 
	keep_words_case: Boolean, 
	keep_words_path: String
) extends TokenFilterBase


@JsonCodec case class KeywordMarkerTokenFilter(
	ignore_case: Boolean, 
	keywords: Array(String), 
	keywords_path: String, 
	keywords_pattern: String
) extends TokenFilterBase


@JsonCodec case class KStemTokenFilter extends TokenFilterBase


@JsonCodec case class LengthTokenFilter(
	max: integer, 
	min: integer
) extends TokenFilterBase


@JsonCodec case class LimitTokenCountTokenFilter(
	consume_all_tokens: Boolean, 
	max_token_count: integer
) extends TokenFilterBase


@JsonCodec case class LowercaseTokenFilter(
	language: String
) extends TokenFilterBase


@JsonCodec case class MultiplexerTokenFilter(
	filters: Array(String), 
	preserve_original: Boolean
) extends TokenFilterBase


@JsonCodec case class NGramTokenFilter(
	max_gram: integer, 
	min_gram: integer
) extends TokenFilterBase


@JsonCodec case class NoriPartOfSpeechTokenFilter(
	stoptags: Array(String)
) extends TokenFilterBase


@JsonCodec case class PatternCaptureTokenFilter(
	patterns: Array(String), 
	preserve_original: Boolean
) extends TokenFilterBase


@JsonCodec case class PatternReplaceTokenFilter(
	flags: String, 
	pattern: String, 
	replacement: String
) extends TokenFilterBase


@JsonCodec case class PorterStemTokenFilter extends TokenFilterBase


@JsonCodec case class PredicateTokenFilter(
	script: Script
) extends TokenFilterBase


@JsonCodec case class RemoveDuplicatesTokenFilter extends TokenFilterBase


@JsonCodec case class ReverseTokenFilter extends TokenFilterBase


@JsonCodec case class SnowballTokenFilter(
	language: SnowballLanguage
) extends TokenFilterBase


@JsonCodec case class StemmerOverrideTokenFilter(
	rules: Array(String), 
	rules_path: String
) extends TokenFilterBase


@JsonCodec case class StemmerTokenFilter(
	language: String
) extends TokenFilterBase


@JsonCodec case class TrimTokenFilter extends TokenFilterBase


@JsonCodec case class TruncateTokenFilter(
	length: integer
) extends TokenFilterBase


@JsonCodec case class UniqueTokenFilter(
	only_on_same_position: Boolean
) extends TokenFilterBase


@JsonCodec case class UppercaseTokenFilter extends TokenFilterBase

type TokenFilter = AsciiFoldingTokenFilter | CommonGramsTokenFilter | ConditionTokenFilter | DelimitedPayloadTokenFilter | EdgeNGramTokenFilter | ElisionTokenFilter | FingerprintTokenFilter | HunspellTokenFilter | HyphenationDecompounderTokenFilter | KeepTypesTokenFilter | KeepWordsTokenFilter | KeywordMarkerTokenFilter | KStemTokenFilter | LengthTokenFilter | LimitTokenCountTokenFilter | LowercaseTokenFilter | MultiplexerTokenFilter | NGramTokenFilter | NoriPartOfSpeechTokenFilter | PatternCaptureTokenFilter | PatternReplaceTokenFilter | PorterStemTokenFilter | PredicateTokenFilter | RemoveDuplicatesTokenFilter | ReverseTokenFilter | ShingleTokenFilter | SnowballTokenFilter | StemmerOverrideTokenFilter | StemmerTokenFilter | StopTokenFilter | SynonymGraphTokenFilter | SynonymTokenFilter | TrimTokenFilter | TruncateTokenFilter | UniqueTokenFilter | UppercaseTokenFilter | WordDelimiterGraphTokenFilter | WordDelimiterTokenFilter
