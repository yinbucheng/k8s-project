# k8s部署测试项目(非k8s测试)

## 模块讲解
```
1.register 注册中心（上k8s可以去掉）

2.server-a 微服务A

3.server-b 微服务B


```

## 注意点
```
1.集成k8s出现下面错误
io.fabric8.kubernetes.client.KubernetesClientException: Failure executing: GET at: https://kubernetes.default.svc/api/v1/namespaces/basic-app/endpoints/server-b. Message: Forbidden!Configured service account doesn't have access. Service account may have been revoked. endpoints "server-b" is forbidden: User "system:serviceaccount:basic-app:default" cannot get endpoints in the namespace "basic-app".

解决办法：
>>在deployment文件中的template.spec添加
serviceAccount：application

>>执行下面命令
kubectl -n basic-app create sa application && kubectl create clusterrolebinding application --clusterrole cluster-admin --serviceaccount=basic-app:application
```