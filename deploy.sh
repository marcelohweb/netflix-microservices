case $1 in
  "build")

    echo "creating compiler container"

    docker build . -t microservices-compiler

    docker run -v $(pwd):/home/compiler/ microservices-compiler

    docker rmi microservices-compiler --force

    echo "compiled!"

  ;;
  "run")
    docker-compose -p "microservices" up -d --force-recreate --build
;;
esac
