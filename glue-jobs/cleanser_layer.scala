import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object CleanserLayer {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder()
      .appName("Cleanser Layer Job")
      .getOrCreate()

    val inputPath = args(0)
    val outputPath = args(1)

    val df = spark.read.parquet(inputPath)

    val cleansedDF = df
      .dropDuplicates()
      .na.fill("UNKNOWN")

    cleansedDF.write
      .mode("overwrite")
      .parquet(outputPath)

    spark.stop()
  }
}