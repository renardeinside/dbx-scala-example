# Sample Scala project for Databricks with dbx support

Sample project for Scala 2.12 and Spark 3.0.1 with `dbx` support, based on some ideas from [cicd-templates](https://github.com/databrickslabs/cicd-templates).


## Instructions 

- Install Python 3.7.5 and pip
- Install `dbx`:
```
pip install dbx
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
