echo "***************************************************"
echo "Building two docker images jvm and native"
echo "***************************************************"
echo ""
rm test_jvm.pdf test_native
echo "**************** building jvm image ****************"
echo ""
echo "**************** building jvm image ****************"
./buildJvmDockerImage.sh
echo "***************************************************"
echo ""
echo "**************** building native image ****************"
./buildNativeDockerImage.sh
echo "***************************************************"
echo ""
echo "**************** deploying to docker ****************"
docker-compose up -d
echo "***************************************************"
echo ""
echo "**************** testing jvm image ****************"
curl http://localhost:8080/pdf > test_jvm.pdf
echo "***************************************************"
echo ""
echo "**************** testing native image ****************"
curl http://localhost:8081/pdf > test_native.pdf
echo "***************************************************"
echo ""
docker logs pdf_service_native_1 |grep Helvetica-BoldOblique
echo "***************************************************"
docker-compose down
echo "**************** end test ****************"
