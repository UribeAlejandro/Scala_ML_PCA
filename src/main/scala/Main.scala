import org.apache.spark.ml.feature.PCA
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.linalg.Vectors


val spark = SparkSession.builder().appName("ML_PCA").getOrCreate()

val data = Array(
  Vectors.sparse(5, Seq((1, 1.0), (3, 7.0))),
  Vectors.dense(2.0, 0.0, 3.0, 4.0, 5.0),
  Vectors.dense(4.0, 0.0, 0.0, 6.0, 7.0)
)

val df = spark.createDataFrame(data.map(Tuple1.apply)).toDF("features")

println(df.show())

val pca = { new PCA()
  .setInputCol("features")
  .setOutputCol("pcaFeatures")
  .setK(3)
  .fit(df)
}

val pcaDF = pca.transform(df)
println(pcaDF.show())

val result = pcaDF.select("pcaFeatures")
result.show()

spark.close()