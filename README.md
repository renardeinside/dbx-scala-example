# Sample Scala project for Databricks with dbx support

Sample project for Scala 2.12 and Spark 3.0.1 with `dbx` support, based on some ideas from [cicd-templates](https://github.com/databrickslabs/cicd-templates).


## Instructions 

- To use `dbx` please install Python 3.7.5 and install it from tools folder via:
```
pip install tools/dbx-0.7.0-py3-none-any.whl
```

- To configure environment, please use:
```
dbx configure \
    --profile <name of your profile from ~/.databrickscfg> 
```
- To deploy the job, configure .jar file name in `conf/deployment.json` and then do:
```
mvn package
dbx deploy --no-rebuild --no-package 
```
- To launch the job, use:
```
dbx launch --job <job-name>
```
- Add `DATABRICKS_HOST` and `DATABRICKS_TOKEN` to GitHub Actions Secrets.