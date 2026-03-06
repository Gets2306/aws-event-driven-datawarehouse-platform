import org.apache.spark.sql.SparkSession

object DWHLoader {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder()
      .appName("DWH Loader Job")
      .getOrCreate()

    val inputPath = args(0)

    val df = spark.read.parquet(inputPath)

    df.write
      .format("jdbc")
      .option("url", "jdbc:redshift://cluster:5439/dev")
      .option("dbtable", "public.fact_table")
      .option("user", "username")
      .option("password", "password")
      .mode("append")
      .save()

    spark.stop()
  }
}