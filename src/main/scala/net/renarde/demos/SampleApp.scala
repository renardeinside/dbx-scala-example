package net.renarde.demos

import org.apache.spark.internal.Logging
import org.apache.spark.sql.SparkSession

object SampleApp extends App with Logging {

  def getSpark: SparkSession = {
    val spark = try {
      SparkSession.builder().getOrCreate()
    } catch {
      case _: org.apache.spark.SparkException =>
        log.info("Using test configuration for spark")
        SparkSession.builder().master("local[*]").appName("test-launch").getOrCreate()
    }
    spark
  }

  val spark = getSpark

  val df1 = spark.range(1, 100).toDF("id")
  val df2 = spark.range(90, 120).toDF("id")

  val result = df1.join(df2, df1("id") === df2("id")).drop(df2("id"))

  result.show()


}
