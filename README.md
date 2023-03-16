# jvm_optimize
对JVM底层技术验证的代码实例,以及优化相关demo

`

## 文件夹相关说明

- `a1_bytecode`:  本文件夹是循序渐进,从最简单的class文件的解读

  可以使用Idea插件Jclasslib来解读,编译完成后到target目录中找到class文件,
  然后在View中点击show bytecode with Jclasslib即可

- `a2_classloader`:  本文将对类加载过程进行代码演示. 包括懒加载, 运行模式, 重写类加载器实现类部署以及class调优案例

