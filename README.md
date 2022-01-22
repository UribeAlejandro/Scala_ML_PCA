# Principal Component Analysis using Spark ML

## How to run?
Start a Spark Shell session
```shell
user $ spark-shell
```

Run the code, using the :load command and you will get a similar result.

```shell
scala> :load src/main/scala/Main.scala
val args: Array[String] = Array()
Loading src/main/scala/Main.scala...
import org.apache.spark.ml.feature.PCA
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.linalg.Vectors
22/01/22 13:50:34 WARN SparkSession$Builder: Using an existing SparkSession; some spark core configurations may not take effect.
val spark: org.apache.spark.sql.SparkSession = org.apache.spark.sql.SparkSession@7e7c780
val data: Array[org.apache.spark.ml.linalg.Vector] = Array((5,[1,3],[1.0,7.0]), [2.0,0.0,3.0,4.0,5.0], [4.0,0.0,0.0,6.0,7.0])
warning: 1 deprecation (since 2.13.0); for details, enable `:setting -deprecation` or `:replay -deprecation`
val df: org.apache.spark.sql.DataFrame = [features: vector]
+--------------------+
|            features|
+--------------------+
| (5,[1,3],[1.0,7.0])|
|[2.0,0.0,3.0,4.0,...|
|[4.0,0.0,0.0,6.0,...|
+--------------------+

()
22/01/22 13:50:40 WARN LAPACK: Failed to load implementation from: com.github.fommil.netlib.NativeSystemLAPACK
22/01/22 13:50:40 WARN LAPACK: Failed to load implementation from: com.github.fommil.netlib.NativeRefLAPACK
val pca: org.apache.spark.ml.feature.PCAModel = PCAModel: uid=pca_c263a9632cfa, k=3
val pcaDF: org.apache.spark.sql.DataFrame = [features: vector, pcaFeatures: vector]
+--------------------+--------------------+
|            features|         pcaFeatures|
+--------------------+--------------------+
| (5,[1,3],[1.0,7.0])|[1.64857282308838...|
|[2.0,0.0,3.0,4.0,...|[-4.6451043317815...|
|[4.0,0.0,0.0,6.0,...|[-6.4288805356764...|
+--------------------+--------------------+

()
val result: org.apache.spark.sql.DataFrame = [pcaFeatures: vector]
+--------------------+
|         pcaFeatures|
+--------------------+
|[1.64857282308838...|
|[-4.6451043317815...|
|[-6.4288805356764...|
+--------------------+

```