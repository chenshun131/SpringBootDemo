#!/bin/bash
dir=/opt/srcs/test/t1
if [ -d ${dir} ]
then
  echo "the '${dir}' is already exists"
else
  mkdir ${dir}
fi
