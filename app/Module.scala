import com.google.inject.AbstractModule
import models.{DataLoader,DataLoaderClass}

class Module extends AbstractModule {

  override def configure() = {
    bind(classOf[DataLoader])
      .to(classOf[DataLoaderClass]).asEagerSingleton

  }

}
