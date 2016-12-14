import com.google.inject.AbstractModule
import services.{DataLoader,DataLoaderClass}

class Module extends AbstractModule {

  override def configure() = {
    bind(classOf[DataLoader])
      .to(classOf[DataLoaderClass]).asEagerSingleton

  }

}
