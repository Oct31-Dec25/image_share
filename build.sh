set -ex

if [ ! -n "$1" ]; then
    VER=`git tag | grep -v "v" | tail -n 1 |  python3 -c "import sys; vers = sys.stdin.readline().strip().split('.'); print('.'.join([*vers[:2], str(int(vers[2])+1)]))"`
else
    VER="$1"
fi
git tag $VER
git push -u origin ${VER}

docker build -t crpi-s3bsa0rxe9jyp91q.cn-guangzhou.personal.cr.aliyuncs.com/kimmy/image_share:$VER .
docker push crpi-s3bsa0rxe9jyp91q.cn-guangzhou.personal.cr.aliyuncs.com/kimmy/image_share:$VER
echo crpi-s3bsa0rxe9jyp91q.cn-guangzhou.personal.cr.aliyuncs.com/kimmy/image_share:$VER

