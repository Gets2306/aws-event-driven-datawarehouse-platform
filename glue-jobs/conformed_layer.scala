import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object ConformedLayer {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder()
      .appName("Conformed Layer Job")
      .getOrCreate()

    val inputPath = args(0)
    val outputPath = args(1)

    val df = spark.read.parquet(inputPath)

    val transformedDF = df
      .withColumn("processed_timestamp", current_timestamp())

    transformedDF.write
      .mode("overwrite")
      .parquet(outputPath)

    spark.stop()
  }
}