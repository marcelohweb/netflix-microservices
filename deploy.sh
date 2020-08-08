case $1 in
  "build")

    echo "creating deploy directory"

    [ ! -d "$(pwd)/netflix-config/deploy" ] && mkdir -p netflix-config/deploy ;
    [ ! -d "$(pwd)/netflix-api-gateway/deploy" ] && mkdir -p netflix-api-gateway/deploy ;
    [ ! -d "$(pwd)/netflix-service-discovery/deploy" ] && mkdir -p netflix-service-discovery/deploy ;
    [ ! -d "$(pwd)/netflix-category-microservice/deploy" ] && mkdir -p netflix-category-microservice/deploy ;
    [ ! -d "$(pwd)/netflix-movie-microservice/deploy" ] && mkdir -p netflix-movie-microservice/deploy ;
    [ ! -d "$(pwd)/netflix-user-microservice/deploy" ] && mkdir -p netflix-user-microservice/deploy ;

    echo "creating compiler container"

    docker build . -t microservices-compiler

    docker run  -v $(pwd):/home/compiler/ microservices-compiler

    docker rmi microservices-compiler --force

    echo "compiled!"

  ;;
  "run")
    docker-compose -p "microservices" up -d --force-recreate --build
;;
esac
